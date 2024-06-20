import { Form,Button } from "react-bootstrap"
import { FormEvent, RefObject } from "react"

const ReviewForm = ({handleSubmit, revText,labelText,defaultValue}:{
    handleSubmit: (e:FormEvent)=> Promise<void>, 
    revText:RefObject<HTMLTextAreaElement>, 
    labelText: string,
    defaultValue: string
}) => {
  return (
    <Form>
        <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
            <Form.Label>{labelText}</Form.Label>
            <Form.Control ref={revText} as={'textarea'} rows={3} defaultValue={defaultValue}/>
        </Form.Group>
        <Button variant="outline-info" onClick={handleSubmit}>Submit</Button>
    </Form>
  )
}

export default ReviewForm