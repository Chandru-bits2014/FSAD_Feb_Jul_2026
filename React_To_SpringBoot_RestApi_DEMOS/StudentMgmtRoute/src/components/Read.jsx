import React,{useState,useEffect} from 'react'
import {useParams} from 'react-router-dom'
import axios from 'axios'
import { Link } from 'react-router-dom'
function Read() {
    const [students,setStudents] = useState([])
    const {rollNo} = useParams();

    useEffect(() => {
        axios.get('http://localhost:8080/students/allStudents/'+rollNo)
        .then(res => setStudents(res.data))
        .catch(err => console.log(err))
    },[])

  return (
    <div className='d-flex w-2100 vh-100 justify-content-center align-items-center bg-light'>
        <div className='w-550 border bg-white shadow px-5 pt-3 pb-5 rounded'>
            <h3> Student Detail</h3>
            <div className='mb-2'>
                <strong>First Name : {students.firstName}</strong>
            </div>
            <div className='mb-2'>
                <strong>Last Name : {students.lastName}</strong>
            </div>
            <div className='mb-2'>
                <strong>Marks : {students.marks}</strong>
            </div>
            <Link to={`/update/${rollNo}`} className='btn btn-success'>Edit</Link>
            <Link to={"/"} className='btn btn-primary ms-3'>Back To Home</Link>
        </div>
    </div>
  )
}

export default Read
