import React, { useState } from 'react' 
import {useNavigate} from 'react-router-dom'
import { useAuth } from './security/AuthContext'

export default function LoginComponent() {

    const [username, setUsername] = useState('dkd')
    const [password, setPassword] = useState('123')
    const navigate = useNavigate()
    const authContext = useAuth()
    
    function handleSubmit(){
        
        if(authContext.login(username, password))
        {
            return navigate(`/welcome/${username}`)
        }
        else{
            console.log("Invalid Credentials")
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
