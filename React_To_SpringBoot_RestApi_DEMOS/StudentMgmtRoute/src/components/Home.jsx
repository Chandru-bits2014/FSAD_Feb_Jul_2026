import React, {useEffect,useState} from 'react'
import axios from 'axios'
import { Link ,useNavigate} from 'react-router-dom'
function Home() {
    const [students,setStudents] = useState([])
    const navigate = useNavigate();
  
    useEffect(() => {
        axios.get('http://localhost:8080/students/allStudents')
        .then(res => setStudents(res.data))
        .catch(err => console.log(err))
    },[])

    const handleDelete =(rollNo) => {
        const confirm = window.confirm("Are you sure , you want to delete this Record");
        if(confirm) {
            axios.delete('http://localhost:8080/students/allStudents/'+rollNo)
            .then(res =>{
               // navigate('/'); //This may not re load
                location.reload();
            }).catch(err => console.log(err));
        }
    }
  return (
    <div className='d-flex flex-column justify-content-center align-items-center bg-light w-1275 vh-100'>
      <h1>List Of Students </h1>

      <div className = 'w-1275 rounded bg-white border shadow p-4'>
        <div className = 'd-flex justify-content-end'>
           <Link to='/create' className='btn btn-success'> Add Student </Link>
        </div>
        <table className='table table-striped'>
            <thead>
                <tr>
                    <th>Roll No</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Marks</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                {
                    students.map((student,i) => (
                        <tr key={i} >
                            <td>{student.rollNo}</td>
                            <td>{student.firstName}</td>
                            <td>{student.lastName}</td>
                            <td>{student.marks}</td>
                            <td>
                                <Link to={`/read/${student.rollNo}`} className='btn btn-sm btn-info me-2'>Read</Link>
                                <Link to={`/update/${student.rollNo}`} className='btn btn-sm btn-primary me-2'>Edit</Link>
                                <button onClick={e => handleDelete(student.rollNo)}className='btn btn-sm btn-danger'>Delete</button>
                            </td>
                        </tr>
                    ))

                }
            </tbody>
        </table>
      </div>
    </div>
  )
}

export default Home
