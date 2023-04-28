import { useParams } from "react-router-dom"
import { useAuth } from "./security/AuthContext"
import { retrieveTodoById } from "./api/HelloWorldApiService"
import { useEffect, useState } from "react"
import { Field, Form, Formik } from "formik"

export default function UpdateComponent() {

    const authContext= useAuth()
    const {id} = useParams()
    const [todo, setTodo] = useState('')
    const [description, setDescription] = useState('')
    const [targetDate, setTargetDate] = useState('')

    useEffect(
        () => refreshTodos()
    ) 

    function refreshTodos()
    {
        
        retrieveTodoById(authContext.username, id)
        .then( (response) =>    
        {
            setTodo( () => {
                const a= response.data
                return a
            })
            setDescription(
                todo.description
            )
            setTargetDate(
                todo.targetDate
            )
        })
        .catch(   (error) =>    console.log(error) )
    }                      

    console.log(todo)

    return(
        <div className="update-component">
            <h1>Update Component</h1>
            Description: {todo.description}
            <div>
                <Formik initialValues={{description, targetDate}} enableReinitialize>
                {
                    (props) => (
                        <Form>
                            <fieldset className="form-group">
                                <label>Description</label>
                                <Field type="text" className="form-control" name="description" />
                            </fieldset>
                            <fieldset className="form-group">
                                <label>Target Date</label>
                                <Field type="text" className="form-control" name="targetDate" />
                            </fieldset>
                        </Form>
                    )
                }
                </Formik>
            </div>
            
        </div>
    )
}