FROM node:21.1 as build-stage  

WORKDIR /app

COPY package.json /app/
COPY package-lock.json /app/
RUN npm install
COPY ./ /app

EXPOSE 5173
CMD ["npm", "run", "dev"]
