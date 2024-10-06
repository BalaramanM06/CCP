// import api from './api/axiosconfig';
import './App.css';
import {useState,useEffect} from 'react';
import Layout from './components/Layout';
import { Routes,Route} from 'react-router-dom';
import Home from './components/home/Home';
import axios from 'axios';

function App() {
  const [movies,setMovies]=useState([]);
  const[loading,setLoading] = useState(true);
  const getMovies=async () =>{
    try{
      const response=await axios.get("http://localhost:8080/api/v1/movies");
      console.log(response.data);
    setMovies(response.data)
    setLoading(false);

    }
    catch(err){
      console.log(err);
      setLoading(false);
    }
    
  }



  useEffect(()=>{
     getMovies();
  },[])

  if(loading){
    return (
      <div> loading</div>
    )
  }

  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Layout/>}>
            <Route path="/" element={<Home movies={movies} />}></Route>
        </Route>
      </Routes>



    </div>
  );
}

export default App;
