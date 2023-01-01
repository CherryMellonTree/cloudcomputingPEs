from flask import Flask, request, jsonify
from graphql_client import GraphQLClient

app = Flask(__name__)

# Create a GraphQL client using the Graphene library
client = GraphQLClient('http://localhost:8080/graphql')

@app.route('/')
def index():
    return '''
        <h2>Get All Students</h2>
        <form id="get-students-form">
            <button type="submit">Get Students</button>
        </form> 
        <div id="get-students-response"></div>
        
        <h2>Get Student</h2>
        <form id="get-student-form">
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name"><br>
            <button type="submit">Get Student</button>
        </form> 
        <div id="get-student-response"></div>
        
        <h2>Add Class to Student</h2>
        <form id="add-class-form">
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name"><br>
            <label for="course">Course:</label><br>
            <input type="text" id="course" name="course"><br>
            <label for="score">Score:</label><br>
            <input type="text" id="score" name="score"><br>
            <button type="submit">Add Class</button>
        </form> 
        <div id="add-class-response"></div>
        
        <h2>Add Student</h2>
        <form id="add-student-form">
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name"><br>
            <button type="submit">Add Student</button>
        </form> 
        <div id="add-student-response"></div>
        <script>
    const getStudentsForm = document.getElementById('get-students-form');
    getStudentsForm.addEventListener('submit', (event) => {
        event.preventDefault();
        fetch('/students')
        .then(response => response.json())
        .then((response) => {
            document.getElementById('get-students-response').innerHTML = JSON.stringify(response);
        });
    });
    
    const getStudentForm = document.getElementById('get-student-form');
    getStudentForm.addEventListener('submit', (event) => {
        event.preventDefault();
        const name = getStudentForm.elements.name.value;
        fetch(`/student?name=${name}`)
        .then(response => response.json())
        .then((response) => {
            document.getElementById('get-student-response').innerHTML = JSON.stringify(response);
        });
    });
    
    const addClassForm = document.getElementById('add-class-form');
    addClassForm.addEventListener('submit', (event) => {
        event.preventDefault();
        const name = addClassForm.elements.name.value;
        const course = addClassForm.elements.course.value;
        const score = addClassForm.elements.score.value;
        const data = { name: name, course: course, score: score };
        fetch('/student/add-class', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        })
        .then(response => response.json())
        .then((response) => {
            document.getElementById('add-class-response').innerHTML = JSON.stringify(response);
        });
    });
    
    const addStudentForm = document.getElementById('add-student-form');
    addStudentForm.addEventListener('submit', (event) => {
        event.preventDefault();
        const name = addStudentForm.elements.name.value;
        const data = { name: name };
        fetch('/student/add', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        })
        .then(response => response.json())
        .then((response) => {
            document.getElementById('add-student-response').innerHTML = JSON.stringify(response);
        });
    });
</script>'''


@app.route('/students', methods=['GET'])
def get_students():
    # Fetch all students using the 'allstudents' query
    result = client.query('''
        query {
            allstudents {
                name
                coursedict {
                    coursename
                    coursescore
                }
            }
        }
    ''')

    # Extract the data from the result and return it as a JSON response
    students = result['data']['allstudents']
    return jsonify(students)

@app.route('/student', methods=['GET'])
def get_student():
    # Get the student name from the query parameters
    name = request.args.get('name')
    
    # Fetch the student using the 'getstudent' query
    result = client.query('''
        query ($name: String!) {
            getstudent(name: $name) {
                name
                coursedict {
                    coursename
                    coursescore
                }
            }
        }
    ''', variables={'name': name})

    # Extract the data from the result and return it as a JSON response
    student = result['data']['getstudent']
    return jsonify(student)

@app.route('/student/add-class', methods=['POST'])
def add_class_to_student():
    # Get the request body data
    data = request.get_json()
    # Extract the student name, course name, and course score from the data
    name = data['name']
    course = data['course']
    score = data['score']

    # Use the 'addClassToStudent' query to add a class to the student
    result = client.query('''
        query ($name: String!, $course: String!, $score: String!) {
            addClassToStudent(name: $name, course: $course, score: $score) {
                name
                coursedict {
                    coursename
                    coursescore
                }
            }
        }
    ''', variables={'name': name, 'course': course, 'score': score})

    # Extract the data from the result and return it as a JSON response
    student = result['data']['addClassToStudent']
    return jsonify(student)

@app.route('/student/add', methods=['POST'])
def add_student():
    # Get the request body data
    data = request.get_json()
    # Extract the student name from the data
    name = data['name']

    # Use the 'addStudent' query to add a new student
    result = client.query('''
        query ($studentname: String!) {
            addStudent(studentname: $studentname) {
                name
                coursedict {
                    coursename
                    coursescore
                }
            }
        }
    ''', variables={'studentname': name})

    # Extract the data from the result and return it as a JSON response
    student = result['data']['addStudent']
    return jsonify(student)
if __name__ == '__main__':
    app.run()

