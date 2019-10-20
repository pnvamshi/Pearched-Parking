const domain = 'http://parkingsolutions-env.uxn4bztsdj.us-east-1.elasticbeanstalk.com/';

function getOptions(data, method, header){
    const options =  {
        method: method ? method : "post",
        body: typeof(data) === "object" ? JSON.stringify(data) : data,
        headers: {
            'Content-Type': 'application/json'
        }
    }
    if (header){
        options.headers = {...options.headers, ...{'Authorization': localStorage.getItem("id_token")}};
    }
    return options;
}

export async function loginService(params) {
    const response = await fetch(`${domain}login/service/get/token`, getOptions(params, "POST"));
    return await response.json();
}

export async function saveVehicle(params){
    // return await API.post('parking/operator/service/save/vehicle/info', params)
    const response = await fetch(`${domain}parking/operator/service/save/vehicle/info`, getOptions(params, "POST", true));
    return await response.json();
}

export async function getVehicleInfo(params){
    // return await API.post('parking/operator/service/get/vehicle/info', params)
    const response = await fetch(`${domain}parking/operator/service/get/vehicle/info`, getOptions(params, "POST", true));
    return await response.json();
}

export async function generateBill(params){
    // return await API.post('parking/operator/service/get/vehicle/info', params)
    const response = await fetch(`${domain}parking/operator/service/get/vehicle/info`, getOptions(params, "POST", true));
    return await response.json();
}

// export async function generateBill(params){
//     // 
// }

export async function getRegions(){
    const response = await fetch(`${domain}parking/user/service/get/parking/region`, getOptions('getregion', "POST", true));
    return await response.json();
}

export async function saveUser(params){
    // return await API.post('parking/admin/service/save/user/profile/info', params)
    const response = await fetch(`${domain}parking/admin/service/save/user/profile/info`, getOptions(params, "POST", true));
    return await response.json();
}

export async function getUsers(params){
    // return await API.post('/parking/admin/service/get/user/names', params)
    const response = await fetch(`${domain}parking/admin/service/get/user/names`, getOptions(params, "POST", true));
    return await response.json();

}