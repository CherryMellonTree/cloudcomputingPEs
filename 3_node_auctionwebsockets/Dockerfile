FROM node:16

WORKDIR /src

COPY ./package.json /src/package.json

RUN npm install

COPY ./* /src/

EXPOSE 3269

CMD ["node", "auctionserver.js"]

