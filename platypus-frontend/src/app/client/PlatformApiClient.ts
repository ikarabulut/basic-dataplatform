import axios from "axios";
import { DataProduct } from "../../types/DataProduct";

export async function getAllDataProducts(): Promise<DataProduct[] | null> {
  const response = await axios.get(`http://localhost:8080/api/catalog/all`, {
    headers: {
      "Access-Control-Allow-Origin": "*",
    },
  });
  if (response.status == 200) return response?.data as DataProduct[];
  return null;
}
