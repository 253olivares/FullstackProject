import { useState, useEffect } from 'react'
import api from './api/axiosConfig'
import './App.css';
import Layout from './components/Layout';
import {Routes, Route} from 'react-router-dom';
import Home from './pages/home/Home';
import Header from './components/header/Header';
import Trailer from './components/trailer/Trailer';
import Reviews from './pages/reviews/Reviews';

export type objectId = {
  date: string,
  timestamp: number
}

export type movie = {
  id: objectId,
  imdbId: string,
  title:string,
  releaseDate:string,
  trailerLink:string,
  genres: string[],
  poster:string,
  backdrops: string[]
  reviewIds: review[]
}

export type review = {
  id:objectId,
  body:string
}

function App() {
  // state to hold all our movies
  const [movies, setMovies] = useState<movie[]>([]);
  // state to hold our select movie
  const [movie,setMovie] = useState<movie|null>(null);
  // state to hold our reviews
  const [reviews,setReviews] = useState<review[]>([]);
  // get all movies
  const getMovies =async () => {
    try{
      const response = await api.get('/movies');
      console.log("Movies: ", response.data[0])
      console.log("Movies: Typeof ", typeof response.data[0].id.date)
      if(response.status === 200 || 204) {
        setMovies(response.data);
      } else {
        throw new Error("ran into issues!");
      } 
    } catch(e){
      console.log("Ran into error fetching data: ",e);
    }
  }

  // get all reviews
  const getReviews = async () => {
    try{
      const response = await api.get('/reviews');
      console.log("reviews:",response);
      console.log("data", typeof response.data[0].id)
      if(response.status === 200 || 204) {
        console.log(response.data);
      }else {
        throw new Error("ran into issues!");
      } 
    } catch (e) {
      console.log('failed to get reviews')
    }
  }

  // get select movie data
  const getMovieData = async (movieId:string):Promise<void> => {
    try{
      console.log('movieId'+ movieId);
      const response = await api.get(`/movies/${movieId}`);
      const singleMovie = response.data;

      setMovie(singleMovie);

      setReviews(singleMovie.reviewIds)
    }catch(e:any){
      console.log(e);
    }
  }

  useEffect(()=>{ 
    getMovies();
    getReviews();
  },[])

  return (
    <div className='App'>
      <Header />
      <Routes>
        <Route path='/' element={<Layout />}>
          <Route index element={<Home movies={movies}/>} />
          <Route path='/trailer/:ytTrailerId' element={<Trailer />}/>
          <Route path='/Reviews/:movieId' element={<Reviews getMovieData={getMovieData} movie ={movie} reviews={reviews} setReviews={setReviews} />}/>
        </Route>
      </Routes>
    </div>
  )
}

export default App
