// sign in
document.getElementById("signin").addEventListener('click', (e) => {
    e.preventDefault()
    console.log("helloo");

    const email = document.getElementById("email").value
    const password = document.getElementById("pwd").value

    if (email == '' || password == '') {
        alert('Please fill in both fields.')
    }
    else {
        const user = {
            email: email,
            password: password
        }
        // console.log(email,password);
        const url = "http://localhost:8081/login"
        const xhr = new XMLHttpRequest();
        xhr.open('POST', url);

        xhr.setRequestHeader('Access-Control-Allow-Origin', '*')
        xhr.setRequestHeader('Content-Type', 'application/json')

        xhr.onreadystatechange = () => {
            if (xhr.status == 200 && xhr.readyState == 4) {
                const response = JSON.parse(xhr.responseText);
                console.log(response);
                if(response==null){
                    alert('Invalid email or password.')
                }
                else{
                    window.location.href = "http://localhost:5501/welcome.html"
                }
                
            }
        }
        xhr.send(JSON.stringify(user));
    }
})