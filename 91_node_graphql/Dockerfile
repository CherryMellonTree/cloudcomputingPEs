FROM node:12-alpine

WORKDIR /app

RUN npm install express express-graphql graphql

COPY . .

EXPOSE 4000

CMD ["node", "graphapp.js"]
