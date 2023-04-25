import { useParams, Link } from "react-router-dom"

export  default  function WelcomeComponent() {
    const params= useParams()
    return (
        <div className="WelcomeComponent">
            <h1>Welcome {params.username}</h1>
            <div>
                Manage your todos - <Link to="/todos">Go here</Link>
            </div>
        </div>
    )
}