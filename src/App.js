import logo from './logo.svg';
import axios from 'axios';
import './App.css';
import Greeting from './components/Greeting';
import { useEffect, useState } from 'react';
import ChallengeList from './components/ChallengeList.js';
import AddChallenge from './components/AddChallenge.js';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const [challenges, setChallenges] = useState(
    [//{id : 1, month : 'January', description : 'Learning a new App'},
    //   {id : 2, month : 'Febrarury', description : 'Build a App'}
    ]
  );

  const fetchChallenges = async () => {
    try {
      const response = await axios.get('http://localhost:8080/challenges');
      // console.log(response.data);
      setChallenges(response.data);
    } catch (error) {
      console.error("Error Fetching challenges: ", error);
    }
  };

  useEffect(() => {
    fetchChallenges();
  }, [])

  const handleChallengeAdded = () => {
    fetchChallenges();
  };

  return (
    <div className="container mt-5">
      <h1 className='text-center mb-4'>Monthly Challenges</h1>
      <AddChallenge  onChallengeAdded = {handleChallengeAdded}/>
      <ChallengeList challenges = {challenges} />
    </div>
  );
}

export default App;
