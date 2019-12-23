FROM node:10.16.0-alpine

WORKDIR /usr/src/app_client
ENV PATH /usr/src/app_client/node_modules/.bin:$PATH

COPY package.json /usr/src/app_client/package.json

RUN npm install

CMD ["npm", "run", "dev"]