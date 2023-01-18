import graphene as graphene

class myClass(graphene.ObjectType):
    coursename = graphene.Field(graphene.String)
    coursescore = graphene.Field(graphene.String)

class studentType(graphene.ObjectType):
  name = graphene.Field(graphene.String)
  coursedict = graphene.Field(graphene.List(myClass))
  
  def __init__(self, name, coursedict):
    self.name = name
    self.coursedict = coursedict
    
  def resolve_name(self, info, **kwargs):
    return self.name
  
  def resolve_coursedict(self, info, **kwargs):
    return self.coursedict

student_list = [
studentType(name = "Jack Smith", coursedict = [myClass(coursename="law",coursescore=9), myClass(coursename="supreme court hearings",coursescore= 9)]),
studentType(name = "Merric Garland", coursedict = [myClass(coursename="law",coursescore=10), myClass(coursename="supreme court hearings",coursescore= 9), myClass(coursename="telling you to do your own job",coursescore= 9)]),
studentType(name = "Gudy Ruliani", coursedict = [myClass(coursename="law",coursescore=0), myClass(coursename="losing oil from the scalp",coursescore= 9)]),
studentType(name = "Steve Steveson", coursedict = [myClass(coursename="law",coursescore=5), myClass(coursename="coming up with good names and courses",coursescore= 0)]),
]

class Query(graphene.ObjectType):
    allstudents = graphene.Field(graphene.List(studentType), description="Returns a list of all students' names")
    
    def resolve_allstudents(self, info, **kwargs):
        return student_list

    getstudent = graphene.Field(studentType, name=graphene.String(required=True), description="Get all the information of a student, using their name")
    def resolve_getstudent(parent, info, name):
        dummystudent = studentType(name = "Not Found", coursedict = [myClass(coursename="fake course", coursescore="0")])
        for student in student_list:
            if student.name == name:
                dummystudent = student
        return dummystudent
    
    addClassToStudent = graphene.Field(studentType, name=graphene.String(required=True), course=graphene.String(required=True), score=graphene.String(required=True), description="Add a course with its details to a student")
    def resolve_addClassToStudent(parent, info, name, course, score):
        dummystudent = studentType(name = "Not Found", coursedict = [myClass(coursename="fake course", coursescore="0")])
        for student in student_list:
            if student.name == name:
                student.coursedict.append(myClass(coursename=course, coursescore=score))
                dummystudent = student
        return dummystudent

    addStudent = graphene.Field(studentType, studentname=graphene.String(required=True), description="Add a new student. They will, following standard procedure, be enrolled into Law automatically.")
    def resolve_addStudent(parent,info,studentname):
        new = studentType(name=studentname, coursedict=[myClass(coursename="law",coursescore=5)])
        student_list.append(new)
        return new