
export async function fetchData(path, method = "GET", body = null, jwt = null) {
    const options = {
        method,
        headers: {
            "Content-Type": "application/json",
        },
    };

    if (jwt) {
        options.headers.Authorization = jwt;
    }
    
    if (method !== "GET" && body) {
        options.body = JSON.stringify(body);
    }

    const response = await fetch(`/api/${path}`, options);
    return response.json();
}
