import './TodoApp.css'
import {BrowserRouter, Routes, Route, useNavigate, Navigate} from 'react-router-dom'
import LogoutComponent from './LogoutComponent';
import LoginComponent from './LoginComponent';
import HeaderComponent from './HeaderComponent';
import FooterComponent from './FooterComponent';
import ListTodosComponent from './ListTodosComponent';
import WelcomeComponent from './WelcomeComponent';
import ErrorComponent from './ErrorComponent';
import AuthProvider from './security/AuthContext';
import {useAuth} from './security/AuthContext'

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <AuthProvider>
                <BrowserRouter>
                    <HeaderComponent />
                    <Routes>
                        <Route path='/' element={
                                <LoginComponent /> 
                        }/>
                        <Route path='/login' element={ <LoginComponent /> }></Route>
                        <Route path='/welcome/:username' element={
                            <AuthenticationRoute>
                                <WelcomeComponent /> 
                            </AuthenticationRoute>
                        }/>
                        <Route path='/todos' element={
                            <AuthenticationRoute>
                                <ListTodosComponent />
                            </AuthenticationRoute>
                        } />
                        <Route path='/logout' element={ <LogoutComponent /> }></Route>
                        <Route path='*' element={
                            <AuthenticationRoute>
                                <ErrorComponent />
                            </AuthenticationRoute>
                        }></Route>
                    </Routes>
                    <FooterComponent />

                </BrowserRouter>
            </AuthProvider>
           
        </div>
    )
}

function AuthenticationRoute( {children} ){
    const authContext= useAuth()
    if(authContext.isAuthenticated)
        return children
    else 
        return <Navigate to="/" />
}










