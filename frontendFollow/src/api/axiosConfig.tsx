import axios from 'axios';

// importing axios to sent up our api endpoint

export default axios.create({
    baseURL: 'http://localhost:8080/api/v1',
    // headers: {
    //     "Access-Control-Allow-Origin": "*",
    //     "Access-Control-Allow-Methods": "GET,PUT,PO ST,DELETE,PATCH,OPTIONS"
    // },
})