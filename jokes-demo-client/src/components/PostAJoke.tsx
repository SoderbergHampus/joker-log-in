import { FormEvent, useState } from 'react';
import { User } from '../App';

type PostAJokeProp = {
  user: User | undefined;
};

const PostAJoke = ({ user }: PostAJokeProp) => {
  const [postJoke, setPostJoke] = useState('');
  const [msg, setMsg] = useState('');

  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    if (postJoke.length < 5) {
      setMsg('The postJoke needs to be at least 5 characters long.');
      return;
    }

    fetch('http://localhost:8080/api/jokes/secure/addJoke', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${user?.jwtToken}`,
      },
      body: JSON.stringify(postJoke),
    })
      .then((res) => {
        res.status === 401 ? setMsg('Go away peasant') : setMsg('Joke posted!');
      })
      .then(() => setPostJoke(''))
      .catch((err) => {
        console.log(err);
      });
  };
  return (
    <>
      <h2>Post your joke here</h2>
      <form onSubmit={handleSubmit} className='form add-joke--form'>
        <label htmlFor='jokeInput'>I am a joke</label>
        <input
          type='text'
          id='jokeInput'
          onChange={(e) => setPostJoke(e.target.value)}
        />
        {msg ? <p className='msg'>{msg}</p> : null}
        <hr />
        <button type='submit'>Submit</button>
      </form>
    </>
  );
};

export default PostAJoke;
