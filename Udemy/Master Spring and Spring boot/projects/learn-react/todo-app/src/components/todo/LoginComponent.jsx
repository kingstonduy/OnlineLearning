import React, { useState } from 'react' 
import {useNavigate} from 'react-router-dom'
import { useAuth } from './security/AuthContext'
import ShowInvalidComponent from './ShowInvalidComponent'

export default function LoginComponent() {

    const [username, setUsername] = useState('dkd')
    const [password, setPassword] = useState('123')
    const navigate = useNavigate()
    const authContext = useAuth()
    const [showInvalidMessage, setShowInvalidMessage] = useState(false)
    
    function handleSubmit(){
        
        if(authContext.login(username, password))
        {   
            setShowInvalidMessage(false)
            return navigate(`/welcome/${username}`)
        }
        else{
            console.log("Invalid Credentials")
            setShowInvalidMessage(true)
            return navigate('/login')
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
            <div className="LoginForm">
                {showInvalidMessage && <ShowInvalidComponent />}
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
