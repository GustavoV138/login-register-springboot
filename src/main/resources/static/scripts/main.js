const apiUrl = "http://localhost:8080"; // muda se tua API estiver em outra porta

// Cadastro
const registerForm = document.getElementById("registerForm");
if (registerForm) {
  registerForm.addEventListener("submit", async (e) => {
    e.preventDefault();
    const user = {
      login: document.getElementById("newUsername").value,
      senha: document.getElementById("newPassword").value
    };

    const res = await fetch(`${apiUrl}/users/register`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(user)
    });

    if (res.ok) {
      alert("Usuário cadastrado!");
      window.location.href = "login.html";
    } else {
      alert("Erro ao cadastrar!");
    }
  });
}

// Login
const loginForm = document.getElementById("loginForm");
if (loginForm) {
  loginForm.addEventListener("submit", async (e) => {
    e.preventDefault();
    const user = {
      login: document.getElementById("username").value,
      senha: document.getElementById("password").value
    };

    const res = await fetch(`${apiUrl}/users/login`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(user)
    });

    if (res.ok) {
      alert("Login bem-sucedido!");
    } else {
      alert("Usuário ou senha inválidos!");
    }
  });
}
