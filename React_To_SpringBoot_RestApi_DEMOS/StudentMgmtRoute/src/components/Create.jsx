import React,{useState} from 'react'
import axios from 'axios'
import { Link ,useNavigate} from 'react-router-dom'
function Create() {
    const [studData,setStudData] = useState({
        firstName :'',
        lastName :'',
        marks : ' '
    })

    const navigate = useNavigate();
    const handleSubmit = (event)=>{
        event.preventDefault();
        axios.post('http://localhost:8080/students/allStudents',studData)
        .then(res => 
            {
            console.log(res);
            navigate('/')
            }
        )
        .catch(err => console.log(err))
    }
  return (
    <div className='d-flex w-100 vh-100 justify-content-center align-items-center bg-light'>
      <div className='w-100 border bg-white shadow px-5 pt-3 pb-5 rounded'>
        <h1>Add a Student</h1>
        <form onSubmit={handleSubmit}>
            <div className='mb-2'>
                <label htmlFor='fname'>First Name :</label>
                <input type='text' name='fname' className='form-control' placeholder='Enter First Name'
                onChange={e => setStudData({...studData,firstName : e.target.value})} />
            </div>
            <div className='mb-2'>
                <label htmlFor='lname'>Last Name :</label>
                <input type='text' name='lname' className='form-control' placeholder='Enter Last Name' 
                 onChange={e => setStudData({...studData,lastName : e.target.value})}/>
            </div>
            <div className='mb-3'>
                <label htmlFor='marks'>Marks :</label>
                <input type='text' name='marks' className='form-control' placeholder='Enter Marks' 
                 onChange={e => setStudData({...studData,marks : e.target.value})}/>
            </div>
            <button className='btn btn-success'>Submit Data</button>
            <Link to='/' className='btn btn-primary ms-3'>Back To Home Page</Link>
        </form>
      </div>
    </div>
  )
}

export default Create
