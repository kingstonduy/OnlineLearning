import { useState } from "react";
import { Navigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

export default function LogoutComponent(){

    const [timer, setTimer] = useState(0);
    const authContext= useAuth()

    setInterval( () => setTimer(timer+1), 100 )
    console.log(timer)
    function logoutPage(){
        authContext.logout()
        return(
            <div className="container">
                <div className="container">
                    <h1>
                        You are logged out
                    </h1>
                </div>
                <div className="container">
                    Thank you for using our application
                </div>
            </div>
        )
    }

    if(timer < 10) return logoutPage()
    else return <Navigate to="/login" />
}
