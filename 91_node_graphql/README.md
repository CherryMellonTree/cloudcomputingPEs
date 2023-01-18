Hello this is a readme, just like my other graphql service has.

{
  sayGoodbye(name:"test") {
    message
  }
  sayHello(name:"Intended use"){
    message
  }
  generateDeepfake(person:"Markx", watermark:true, anger:3){
    message,
    safety,
    watermark,
    impact,
    link
  }
  generateFunnyDeepfake(person:"Phteven", watermark:true, anger:0, funny:true ){
    message,
    safety,
    watermark,
    impact,
    link
  }
  generatePoliticalDeepfake(person:"Julius", watermark:true, anger:10, progressive:false){
    message,
    link,
    safety,
    watermark,
    impact,
  }
}
