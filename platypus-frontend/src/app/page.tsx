'use client'
import React from "react";
import { useEffect, useState } from "react";

import {
  Navbar,
  NavbarBrand,
  NavbarContent,
  NavbarItem,
  Link,
  Button,
} from "@nextui-org/react";
import {Table, TableHeader, TableColumn, TableBody, TableRow, TableCell, getKeyValue} from "@nextui-org/react";

import { DataProduct } from "../types/DataProduct"
import { getAllDataProducts } from "./client/PlatformApiClient";


export default function App() {
  const [dataProducts, setDataProducts] = useState<DataProduct[]>([]);

  useEffect(() => {
    (async () => {
      const data = await getAllDataProducts()
        if (data && !dataProducts || data && dataProducts.length !== data.length) {
          setDataProducts(data)
        }
    })();
  })

  const columns = [
    { key: 'id', label: 'ID' },
    { key: 'name', label: 'NAME' },
    { key: 'version', label: 'VERSION' },
    { key: 'primaryContact', label: 'PRIMARY CONTACT' },
    { key: 'database', label: 'DATABASE' },
    { key: 'domain', label: 'DOMAIN' }
  ];

  return (
    <main className="flex min-h-screen flex-col items-center p-4 bg-white">
      <Navbar>
        <NavbarBrand>
          <p className="font-bold text-inherit">Platypus</p>
        </NavbarBrand>
        <NavbarContent className="hidden sm:flex gap-4" justify="center">
          <NavbarItem>
            <Link color="foreground" href="#">
              Features
            </Link>
          </NavbarItem>
          <NavbarItem>
            <Link color="foreground" href="#">
              Customers
            </Link>
          </NavbarItem>
          <NavbarItem>
            <Link color="foreground" href="#">
              Integrations
            </Link>
          </NavbarItem>
        </NavbarContent>
        <NavbarContent justify="end">
          <NavbarItem className="hidden lg:flex">
            <Link href="#">Login</Link>
          </NavbarItem>
          <NavbarItem>
            <Button as={Link} color="primary" href="#" variant="flat">
              Sign Up
            </Button>
          </NavbarItem>
        </NavbarContent>
      </Navbar>

      <div className="container">
        <Table>
          <TableHeader columns={columns}>
            {(column) => <TableColumn key={column.key}>{column.label}</TableColumn>}
          </TableHeader>
          <TableBody items={dataProducts}>
            {(item) => (
              <TableRow key={item.id}>
                {(columnKey) => {
                  return (
                    <TableCell>{getKeyValue(item, columnKey)}</TableCell>
                  )
                }}
              </TableRow>
            )}
          </TableBody>
        </Table>
      </div> 
    </main>

)}
