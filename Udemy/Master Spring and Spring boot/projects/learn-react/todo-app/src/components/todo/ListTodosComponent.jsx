import { useEffect, useState } from "react"
import { deleteTodoById, retrieveAllTodosForUsername } from "./api/HelloWorldApiService"
import { useAuth } from "./security/AuthContext"

export default function ListTodosComponent() {

    const today = new Date()
    
    const targetDate = new Date(today.getFullYear()+12, today.getMonth(), today.getDay())

    const [todos, setTodos] = useState([])
    const [message, setMessage] = useState(null)
    const authContext= useAuth()
    
    useEffect(
        () => refreshTodos()
    ) 

    function refreshTodos()
    {
        retrieveAllTodosForUsername(authContext.username)
        .then( (response) =>    
        {
            setTodos( () => {
                const a= response.data
                return a
            })
        })
        .catch(   (error) =>    console.log(error) )
    }
    // here

    function deteleTodo(id)
    {
        console.log(id)
        deleteTodoById(authContext.username, id)
        .then( (response) =>
        {
            refreshTodos()
            setMessage('Delete Successful')

        })
        .catch( (error) => console.log(error) )
    }
    console.log(authContext.username)
    return (
        <div className="ListTodosComponent">
            <h1>Things You Want To Do!</h1>
            <div>
                {message && <div className="alert alert-success">{message}</div>}
                <table className='table'>
                    <thead>
                            <tr>
                                <td>ID</td>
                                <td>Description</td>
                                <td>Is Done?</td>
                                <td>Target Date</td>
                            </tr>
                    </thead>
                    <tbody>
                    {
                        todos.map(
                            todo => (
                                <tr key={todo.id}>
                                    <td>{todo.id}</td>
                                    <td>{todo.description}</td>
                                    <td>{todo.done.toString()}</td>
                                    <td>{todo.targetDate.toString()}</td>
                                    <td>
                                        <input type="submit" name="btn-update" value="Delete" onClick={ () => deteleTodo(todo.id) } />
                                    </td>
                                </tr>
                            )
                        )
                    }
                    </tbody>

                </table>
            </div>
        </div>
    )
}
