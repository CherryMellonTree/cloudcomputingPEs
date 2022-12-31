run: python3 app.py
queries on: http://127.0.0.1:8080/graphql

{addClassToStudent(name:"Jack Smith", course:"bullshittery", score:"7"){
    name
    coursedict{
      coursename
      coursescore
    }}
  allstudents{
  name
  coursedict{
    coursename
    coursescore
  }
}
  getstudent(name:"Jack Smith"){
    name
    coursedict{
      coursename
      coursescore
    }
  }
}