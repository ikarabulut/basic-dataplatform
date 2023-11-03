from fastapi.testclient import TestClient
from app.main import app


class TestApp:

    def test_smoketest(self):
        client = TestClient(app)
        response = client.get("/")
        assert response.status_code == 200
