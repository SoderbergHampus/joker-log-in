import { CredentialResponse, googleLogout } from '@react-oauth/google';
import { FormEvent } from 'react';
import { User } from '../App';

type JokeRenderPageProp = {
  user: User;
  setJwt: (response: CredentialResponse | undefined) => void;
};

const JokeRenderPage = ({ user, setJwt }: JokeRenderPageProp) => {
  const handlelogout = (e: FormEvent) => {
    e.preventDefault();
    googleLogout();
    setJwt(undefined);
  };
  return (
    <>
      <img src={user.picture} />
      <div>Name: {user.name}</div>
      {/* <button onClick={logOut}>LogOut</button> */}
      {/* <button onClick={fetchJoke}>Get the joke</button> */}
      <form onSubmit={handlelogout}>
        <button type='submit'>Log Out</button>
      </form>
    </>
  );
};
export default JokeRenderPage;
