const { buildSchema } = require('graphql');

const schema = buildSchema(`
  """ How intense a certain value is, because a boolean is sometimes not descriptive enough"""
  enum Severity{
    LOW
    MEDIUM
    HIGH
  }
  """  A response containing information about a deepfake. """
  type deepfakeResponse{
    message: String
    link: String
    watermark: Boolean
    safety: Severity
    impact: Severity
  }
  """ The simplest kind of response, with only a single message."""
  type simpleResponse {
    message: String
  }


  type Query {
    """ Simple test message: say hello"""
    sayHello(name: String!): simpleResponse
    """ Simple deprecated test message"""
    sayGoodbye(name: String!): simpleResponse @deprecated(reason:"you can check out any time you want, but you can never leave")
    """ Generate a generic deepfake """
    generateDeepfake(person: String, watermark: Boolean, anger:Int): deepfakeResponse
    """ Generate a politically tinted deepfake """
    generatePoliticalDeepfake(person: String, watermark: Boolean, anger: Int, progressive: Boolean): deepfakeResponse
    """ Create a comedic deepfake"""
    generateFunnyDeepfake(person: String, watermark: Boolean, anger: Int, funny: Boolean): deepfakeResponse
  }

`);

const rootValue = {
    sayHello: ({ name }) => {
      return { message: `Hello, ${name}` };
    },
    sayGoodbye: ({ name }) => {
        return { message: `Goodbye, ${name}` };
      },
    generateDeepfake: ({ person, watermark, anger }) => {
        return { message: `This is a URL to a deepfake of ${person} with an anger level of ${anger}`,  link:`definitely.real.be/${person}`, watermark: watermark, safety:"MEDIUM" ,impact:"MEDIUM"};
      },
    generatePoliticalDeepfake: ({ person, watermark, anger, progressive }) => {
        return { message: `This is a URL to a political deepfake of ${person} with an anger level of ${anger} and a progressive value of ${progressive}`,  link:`definitely.real.be/${person}`, watermark: watermark, safety:"LOW" ,impact:"HIGH"};
      },
    generateFunnyDeepfake: ({ person, watermark, anger,funny }) => {
        return { message: `This is a URL to a funny deepfake of ${person} with an anger level of ${anger} and a funny value of ${funny}`,  link:`definitely.real.be/${person}`, watermark: watermark, safety:"HIGH" ,impact:"LOW"};
      },
  };

module.exports = { schema, rootValue };
