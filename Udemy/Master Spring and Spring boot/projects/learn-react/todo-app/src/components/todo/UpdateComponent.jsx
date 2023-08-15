import { useNavigate, useParams } from "react-router-dom"
import { useAuth } from "./security/AuthContext"
import { retrieveTodoById, updateTodoApi } from "./api/HelloWorldApiService"
import { useEffect, useState } from "react"
import { ErrorMessage, Field, Form, Formik } from "formik"

export default function UpdateComponent() {

    const authContext= useAuth()
    const {id} = useParams()
    const [todo, setTodo] = useState('')
    const [description, setDescription] = useState('')
    const [targetDate, setTargetDate] = useState('')
    const navigate= useNavigate()
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

    function onSubmit(value){
        const todo={
            id: id,
            username: authContext.username,
            description:    value.description,
            targetDate: value.targetDate,
            done: false
        }
        console.log(todo)
        updateTodoApi(authContext.username, id, todo).then(response => {navigate('/todos')})
                                                     .catch(error => console.log(error))
    }
    function validate (values)
    {
        let errors= {}
        if(values.description.length<5)
        {
            errors.description= 'Enter at least 5 characters'
        }
        console.log(values.targetDate)
        if(values.targetDate === '')
        {
            errors.targetDate=  'Enter a valid date'
        }
        return errors
    }

    return(
        <div className="update-component">
            <h1>Update Component</h1>
            Description: {todo.description}
            <div>
                <Formik initialValues={{description, targetDate}} enableReinitialize = {true} onSubmit={onSubmit} validate= {validate}>
                {
                    (props) => (
                        <Form>
                            <ErrorMessage 
                                name='description'
                                component='div'
                                className='alert alert-warning'
                            />
                            <ErrorMessage 
                                name='targetDate'
                                component='div'
                                className='alert alert-warning'
                            />
                            <fieldset className="form-group">
                                <label>Description</label>
                                <Field type="text" className="form-control" name="description" />
                            </fieldset>
                            <fieldset className="form-group">
                                <label>Target Date</label>
                                <Field type="text" className="form-control" name="targetDate" />
                            </fieldset>
                            <div>
                                <button type="submit" className="btn">Save</button>
                            </div>
                        </Form>
                    )
                }
                </Formik>
            </div>
            
        </div>
    )
}