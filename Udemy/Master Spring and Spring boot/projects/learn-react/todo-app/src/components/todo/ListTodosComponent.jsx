import { useEffect, useState } from "react"
import { retrieveAllTodosForUsername } from "./api/HelloWorldApiService"

export default function ListTodosComponent() {

    const today = new Date()
    
    const targetDate = new Date(today.getFullYear()+12, today.getMonth(), today.getDay())

    const [todos, setTodos] = useState([])
    
    useEffect(
        () => refreshTodos()
    ) 

    function refreshTodos()
    {
        retrieveAllTodosForUsername('duy')
        .then( (response) =>    
        {
            setTodos( () => {
                const a= response.data
                return a
            })
            console.log(response) 
        })
        .catch(   (error) =>    console.log(error) )
    }
    // here
    
    return (
        <div className="ListTodosComponent">
            <h1>Things You Want To Do!</h1>
            <div>
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
