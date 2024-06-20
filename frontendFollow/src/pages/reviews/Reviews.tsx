import { FormEvent, useEffect, useRef } from "react";
import api from '../../api/axiosConfig';
import { useParams } from "react-router-dom";
import { Container, Row, Col } from "react-bootstrap";
import ReviewForm from "../../components/reviewForm/ReviewForm";
import React from "react";
import { movie, review } from "../../App";

const Reviews = ({getMovieData, movie, reviews, setReviews} : 
    {
        getMovieData:(movieId:string)=> void, 
        movie:movie|null,
        reviews:review[],
        setReviews:React.Dispatch<React.SetStateAction<any>>
    
    }) => {
    const revText = useRef<HTMLTextAreaElement>(null);
    let params = useParams();
    const movieId = params.movieId;

    console.log('reviews')

    useEffect(()=> {
        if(movieId) getMovieData(movieId);
    },[])

    const addReview = async (e:FormEvent)=> {
        e.preventDefault();
        if(!revText.current) return;

        const rev = revText.current;

        try{

            const response = await api.post('/reviews/addReview',{reviewBody:rev.value, imdbId:movieId});

            console.log(response);

            const updatedReviews = [...reviews, {body:rev.value}];
    
            rev.value = "";
    
            setReviews(updatedReviews);
            
        } catch(e:any){
            console.log(e);
        }
    }

  return (
    <Container>
        <Row>
            <Col><h3>Reviews</h3></Col>
        </Row>
        <Row className="mt-2">
            <Col>
                <img src={movie? movie.poster: ''} alt="" />
            </Col>
            <Col>
                {
                    <>
                        <Row>
                            <Col>
                                <ReviewForm handleSubmit={addReview} revText={revText} labelText="Write a Review?" defaultValue=""/>
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <hr/>
                            </Col>
                        </Row>
                    </>
                }
                {
                reviews ? reviews.map((r:review,i)=> {
                        return (
                            <React.Fragment key={r.body+i}>
                                <Row>
                                    <Col>{r.body}</Col>
                                </Row>
                                <Row>
                                    <Col>
                                        <hr />
                                    </Col>
                                </Row>
                            </React.Fragment>
                        )
                    }) : ''
                }
            </Col>
        </Row>
        <Row>
            <Col>
                <hr />
            </Col>
        </Row>
    </Container>
  )
}

export default Reviews