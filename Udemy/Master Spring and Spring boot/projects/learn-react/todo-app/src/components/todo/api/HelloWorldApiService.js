import axios from 'axios'

const apiClient= axios.create(
    {
        baseURL: 'http://localhost:8080'
    }
)

export const retrieveAllTodosForUsername = (username) => apiClient.get(`/user/${username}/todos`)
export const retrieveTodoById = (username, id) => apiClient.get(`/user/${username}/todos/${id}`)
export const deleteTodoById = (username, id) => apiClient.delete(`/user/${username}/todos/${id}`)
export const retrieveHelloWorldBean= () => apiClient.get('/hello-world-bean')
