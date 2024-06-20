import { useState, useEffect } from 'react'
import api from './api/axiosConfig'
import './App.css';
import Layout from './components/Layout';
import {Routes, Route} from 'react-router-dom';
import Home from './pages/home/Home';

function App() {
  const [movies, setMovies] = useState([])

  const getMovies =async () => {
    try{
      const response = await api.get('/movies');

      if(response.status === 200) {
        setMovies(response.data);
      } else {
        throw new Error("ran into issues!");
      } 
    } catch(e){
      console.log("Ran into error fetching data: ",e);
    }
  }

  useEffect(()=>{ getMovies() },[])

  return (
    <div className='App'>
      <Routes>
        <Route path='/' element={<Layout />}>
          <Route index element={<Home movies={movies}/>} />
        </Route>
      </Routes>
    </div>
  )
}

export default App
