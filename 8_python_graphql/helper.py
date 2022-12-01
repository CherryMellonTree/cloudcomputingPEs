import graphene as gph

class student(gph.ObjectType):
    name = gph.Field(gph.String)
    coursedict = gph.Field(gph.__dict__)
    # def __init__(self, name, coursedict):
    #     self.name = name
    #     self.coursedict = coursedict


class graderepo:
    def __init__(self):
        student1 = student(name = "Jack Smith", coursedict = {"law": 9, "supreme court hearings": 9})
        student2 = student(name = "Merric Garland",coursedict = {"law": 10, "supreme court  hearings": 10, "telling you to do your own job": 10})
        student3 = student(name = "Gudy Ruliani", coursedict = {"law":0, "losing oil from the scalp": 7})
        student4 = student(name = "Steve Steveson", coursedict = {"law": 5, "coming up with good names and courses": 0})
        self.resultDict = { 1:student1, 2:student2, 3:student3, 4:student4}
    
    def add_student(self, student):
        self.resultDict[self.resultDict.__len__()+1] = student
    
    def get_student(self, name):
        result = []
        for k in self.resultDict:
            if self.resultDict[k].name == name:
                result.append(self.resultDict[k].coursedict)
        return result if result.__len__() > 0 else "No student found"
    
    def add_grade(self, id, course, grade):
        self.resultDict[id].coursedict[course]=grade

class Query(gph.ObjectType):
    def __init__(self):
        return "potato"