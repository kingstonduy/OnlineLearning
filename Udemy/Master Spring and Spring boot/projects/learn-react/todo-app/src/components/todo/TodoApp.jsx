import './TodoApp.css'
import React, { useState } from 'react' 
import {BrowserRouter, Routes, Route, useNavigate, useParams, Link} from 'react-router-dom'



export default function TodoApp() {
    return (
        <div className="TodoApp">
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={ <LoginComponent /> }></Route>
                    <Route path='/login' element={ <LoginComponent /> }></Route>
                    <Route path='/welcome/:username' element={<WelcomeComponent /> }></Route>
                    <Route path='/todos' element={<ListTodosComponent /> } />

                    <Route path='*' element={<ErrorComponent />}></Route>
                </Routes>
            </BrowserRouter>
        </div>
    )
}


function LoginComponent() {

    const [username, setUsername] = useState('dkd')
    const [password, setPassword] = useState('123')
    const [showSuccessMessage, setShowSuccessMessage] = useState(false)
    const [showErrorMessage, setShowErrorMessage] = useState(false)
    const navigate = useNavigate()

    
    function handleSubmit(){
        if(username === 'dkd' && password === '123')
        {
            console.log("Login Successful")
            setShowSuccessMessage(true)
            setShowErrorMessage(false)
            navigate(`/welcome/${username}`)
            
        }
        else{
            console.log("Invalid Credentials")
            setShowSuccessMessage(false)
            setShowErrorMessage(true)
        }
    }
    
    function handleUsernameChange(event) {
        
        setUsername(event.target.value)
        console.log(username)
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value)
        console.log(password)
    }
    

    return (
        <div className="Login">
            {showSuccessMessage &&  <div className="SuccessMessage">Login Successful</div>}
            {showErrorMessage &&  <div className="ErrorMessage">Invalid Credentials</div>}
            <div className="LoginForm">
                <div>
                    <label>User Name:</label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange}/>
                </div>
                <div>
                    <label>Password:</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange} />
                </div>
                <div>
                    <button type="button" name="login" onClick={handleSubmit}>login</button>
                </div>
            </div>
        </div>
    )
}

function WelcomeComponent() {
    const params= useParams()
    console.log(params)
    return (
        <div className="WelcomeComponent">
            <h1>Welcome {params.username}</h1>
            <div>
                Manage your todos - <Link to="/todos">Go here</Link>
            </div>
        </div>
    )
}


function ErrorComponent() {
    return (
        <div className="ErrorComponent">
            <h1>We are working really hard!</h1>
            <div>
                Apologies for the 404. Reach out to our team at 
            </div>
            <a href="https://www.facebook.com/kduyyy/">Author</a>
        </div>
    )
}


function ListTodosComponent() {

    const today = new Date()
    
    const targetDate = new Date(today.getFullYear()+12, today.getMonth(), today.getDay())
    
    const todos = [
                    {id: 1, description: 'Learn AWS', done: false, targetDate:targetDate},
                    {id: 2, description: 'Learn Full Stack Dev', done: false, targetDate:targetDate},
                    {id: 3, description: 'Learn DevOps', done: false, targetDate:targetDate},
                ]


    return (
        <div className="ListTodosComponent">
            <h1>Things You Want To Do!</h1>
            <div>
                <table>
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
                                    <td>{todo.targetDate.toDateString()}</td>
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