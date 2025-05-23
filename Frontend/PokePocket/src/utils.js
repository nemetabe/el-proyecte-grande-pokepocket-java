
import badge1 from "./assets/badge1.png"
import badge2 from "./assets/badge2.png"
import badge3 from "./assets/badge3.png"

export let badges = [{
    picture:badge1,
    metReg:true,
},{
    picture:badge2,
    metReg:false,
},{
    picture:badge3,
    metReg:true,
}].sort((a,b) => b.metReg-a.metReg);

export async function fetchData(path, method = "GET", body = null, jwt = null, hasRequestBody = true) {
    const options = {
        method,
        headers: {
            "Content-Type": "application/json",
        },
    };

    if (jwt) {
        options.headers.authorization = `Bearer ${jwt}`;
    }
    
    if (method !== "GET" && body) {
        options.body = JSON.stringify(body);
    }

    const response =  await fetch(`/api/${path}`, options);

    if (response.status === 401) {
        localStorage.setItem("pokePocketJwt", "null");
        window.location.href = "/";
    }

    const contentType = response.headers.get("content-type");
    const isJson = contentType && contentType.includes("application/json");

    const text = await response.text();
    const data = isJson ? JSON.parse(text) : text;

    if (!response.ok) {
        throw {
            status: response.status,
            message: typeof data === "string" ? data : data?.message || "Unknown error occurred",
            data,
        };
    }

    return data;
}


