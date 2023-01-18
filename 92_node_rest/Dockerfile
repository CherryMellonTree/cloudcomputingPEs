FROM node:12-alpine

WORKDIR /app

RUN npm install express body-parser

COPY . .

EXPOSE 3000

CMD ["node", "nodeapp.js"]
