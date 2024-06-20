import './Hero.css';
import Carousel from 'react-material-ui-carousel';
import {Paper} from '@mui/material';

const Hero = ({movies}:{movies:any}) => {
  return (
    <div className='movie-carousel-container'>
        <Carousel>
        {
            movies.map((movie:any)=> {
                return(
                    <Paper key={movie.imdbId}>
                        <div className='movie-card-container'>
                            {/* @ts-ignore */}
                            <div className="movie-card" style={{"--img": `url(${movie.backdrops[0]})`}}>
                                <div className='movie-detail'>
                                    <div className='movie-poster'>
                                        <img src={movie.poster} alt="movies" />
                                    </div>
                                    <div className='movie-title'>
                                        <h1>{movie.title}</h1>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </Paper>
                )
            })
        }
        </Carousel>
    </div>  
  )
}

export default Hero