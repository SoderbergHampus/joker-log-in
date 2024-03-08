import { useEffect, useState } from 'react';
import './App.css';
import {
  CredentialResponse,
  GoogleLogin,
  GoogleOAuthProvider,
} from '@react-oauth/google';

import PostAJoke from './components/PostAJoke';
import { jwtDecode } from 'jwt-decode';
import JokeRenderPage from './components/JokeRenderPage';

export type User = {
  name: string;
  picture: string;
  jwtToken: string;
  role?: string;
};

function App() {
  const [randomJoke, setRandomJoke] = useState('');
  const [jwt, setJwt] = useState<CredentialResponse | undefined>();
  const [user, setUser] = useState<User>();
  useEffect(() => {
    fetchRandomJoke();
  }, []);

  useEffect(() => {
    if (jwt !== undefined && jwt.credential !== undefined) {
      const decodedJson = jwtDecode<User>(jwt.credential);
      setUser({
        name: decodedJson.name,
        picture: decodedJson.picture,
        jwtToken: jwt.credential,
      });
    } else {
      setUser(undefined);
    }
  }, [jwt]);

  const fetchRandomJoke = () => {
    fetch(`http://localhost:8080/api/jokes/public/random`)
      .then((res) => res.json())
      .then((res) => res.content)
      .then((res) => setRandomJoke(res))
      .catch((err) => console.log(err));
  };

  // const clientId =
  //   '829819822167-tdteh18tpvd4h3rg7gu42bbhogncmg5d.apps.googleusercontent.com';
  const clientId = import.meta.env.VITE_CLIENT_ID;
  return (
    <>
      <GoogleOAuthProvider clientId={clientId}>
        <GoogleLogin
          onSuccess={(resp: CredentialResponse) => {
            setJwt(resp);
          }}
          onError={() => console.log('Error in google login')}
        />
        {user !== undefined && <JokeRenderPage user={user} setJwt={setJwt} />}
      </GoogleOAuthProvider>
      <PostAJoke user={user} />
      <div data-testid='test'>{randomJoke}</div>
    </>
  );
}

export default App;
