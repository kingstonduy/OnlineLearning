import { useParams, Link } from "react-router-dom"
import { retrieveAllTodosForUsername } from "./api/HelloWorldApiService"
import { useState } from "react"
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';

export  default  function WelcomeComponent() {
    const params= useParams()
    const [message, setMessage]= useState('sth')

    function calledHelloWorldRestApi    (){
        retrieveAllTodosForUsername('duy')
                              .then( (response) =>    successfulResponse(response) )
                              .catch( (error) =>     errorResponse(error) )
                              .finally (() => console.log('clean up'))
    
    }
    function successfulResponse(response)
    {
        console.log(response)
        setMessage(response.data.message)
    }
    function errorResponse(error)
    {
        setMessage('Error Occured')
    }
    return (
        <div className="WelcomeComponent">
            <h1>Welcome {params.username}</h1>
            <div>
                Manage your todos - <Link to="/todos">Go here</Link>
            </div>
            
            <div>
                <button className="btn btn-successs m-5" onClick={calledHelloWorldRestApi}>Activate call api</button>
            </div>
            <div>
                {message}
            </div>

        </div>
    )
}