FROM python:3.11-slim

ENV PATH="/venv/bin:${PATH}"
ENV VIRTUAL_ENV="/venv"
ENV PIP_DEFAULT_TIMEOUT=100 \
    PIP_DISABLE_PIP_VERSION_CHECK=1 \
    PIP_NO_CACHE_DIR=1 \
    POETRY_VERSION=1.3.1

RUN pip install "poetry==$POETRY_VERSION"
RUN python -m venv /venv

WORKDIR /usr/src/app

COPY pyproject.toml poetry.lock README.md ./
COPY src ./src

RUN poetry config virtualenvs.in-project true && \
    poetry install --only=main --no-root && \
    poetry build -f wheel

RUN pip install dist/*.whl
CMD ["uvicorn", "src.main:app", "--host", "0.0.0.0", "--reload"]
