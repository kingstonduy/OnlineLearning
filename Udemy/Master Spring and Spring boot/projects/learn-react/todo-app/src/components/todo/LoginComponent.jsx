import React, { useState } from 'react' 
import {useNavigate} from 'react-router-dom'

export default function LoginComponent() {

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
