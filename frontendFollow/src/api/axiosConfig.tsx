import axios from 'axios';

// importing axios to sent up our api endpoint

export default axios.create({
    baseURL: 'http://localhost:8080/api/v1/',
    // headers: {"ngrok-skip-browser-warning": "true"}
})