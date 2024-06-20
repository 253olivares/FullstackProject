import Hero from "../../components/hero/Hero"

const Home = ({movies}: {movies:any}) => {
  return (
    <Hero movies = {movies} />
  )
}

export default Home;