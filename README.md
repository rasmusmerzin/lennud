# lennud

This is a practice project for CGI summer internship.

## Running the project

To run the project, you need JDK 21 and Node.js with npm installed.

To run the backend, navigate to the `backend` directory and run the following
command:

```
./gradlew bootRun
```

To run the frontend (in another terminal session), navigate to the `frontend`
directory and run the following command:

```
npm install
npm run dev
```

The frontend should now be available at `http://localhost:5173` and backend at
`http://localhost:8080`.

## Development

I started the project by creating a new Spring Boot project using the
[Spring Initializr](https://start.spring.io). I added Spring Web as a
dependency.

I hardcoded the list of flights and plane layout in repository classes. I
created a REST controller to expose the data to the frontend.

Once the backend was working, I moved existing code to the `backend` directory
and created a new SvelteKit project (with Tailwind, Typescript and Prettier) in
the `frontend` directory.

I then created two routes in the frontend - one for the list of flights and one
for the flight booking with plane layout. I initially displayed the data in
stringified JSON format.

After that, I started creating the UI components.

## Difficulties

I had some difficulties with seat suggestions. It was hard to grasp the intended
user experience and how to implement it. I ended up implementing action buttons
to add a window seat, aisle seat or seat with legspace (which are disabled if
seats of kind are occupied).

## Time spent

I spent around 8 hours on the backend and around 12 hours on the frontend.
