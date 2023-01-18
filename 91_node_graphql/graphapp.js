const express = require('express');
const { graphqlHTTP } = require('express-graphql');

const { schema, rootValue } = require('./schema');

const app = express();



app.use('/graphql', graphqlHTTP({
  schema: schema,
  rootValue: rootValue,
  graphiql: true,
}));


const port = 4000;
app.listen(port, () => {
  console.log(`API server listening on port ${port}`);
});
