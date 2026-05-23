import React,{useState,useEffect} from 'react'
import {useParams} from 'react-router-dom'
import axios from 'axios'
import { Link ,useNavigate} from 'react-router-dom'
function Update() {
  
    //const [students,setStudents] = useState([])
    const {rollNo} = useParams();

    const [studData,setStudData] = useState({
      firstName :'',
      lastName :'',
      marks : ' '
  })
    useEffect(() => {
        axios.get('http://localhost:8080/students/allStudents/'+rollNo)
        .then(res => setStudData(res.data))
        .catch(err => console.log(err))
    },[])
    const navigate = useNavigate();
    const handleUpdate =(event)=>{
      event.preventDefault();
      axios.put('http://localhost:8080/students/allStudents/'+rollNo,studData)
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
      <h1>Update Student</h1>
      <form onSubmit={handleUpdate}>
          <div className='mb-2'>
              <label htmlFor='fname'>First Name :</label>
              <input type='text' name='fname' className='form-control' placeholder='Enter First Name'
              value = {studData.firstName} 
              onChange={e => setStudData({...studData,firstName : e.target.value})} />
          </div>
          <div className='mb-2'>
              <label htmlFor='lname'>Last Name :</label>
              <input type='text' name='lname' className='form-control' placeholder='Enter Last Name' 
               value = {studData.lastName} 
               onChange={e => setStudData({...studData,lastName : e.target.value})}/>
          </div>
          <div className='mb-3'>
              <label htmlFor='marks'>Marks :</label>
              <input type='text' name='marks' className='form-control' placeholder='Enter Marks' 
                value = {studData.marks} 
                onChange={e => setStudData({...studData, marks : e.target.value})} />
          </div>
          <button className='btn btn-success'>Update Data</button>
          <Link to='/' className='btn btn-primary ms-3'>Back To Home Page</Link>
      </form>
    </div>
  </div>
  )
}

export default Update
