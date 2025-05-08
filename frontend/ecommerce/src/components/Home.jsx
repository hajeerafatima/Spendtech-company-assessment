import React from 'react'
import { useEffect, useState } from 'react'
import ProductList from './ProductList';
import Header from './Header';
import CategoryFilter from './CategoryFilter';

const Home = () => {

     const [products, setProducts] = useState([]);
      const [categories, setCategories] = useState([])
      const [selectedCategory, setSelectedCategory] = useState(null)
      const [searchTerm, setSearchTerm] = useState("")
      const [sortOrder, setSortOrder] = useState("asc")
    
      useEffect(() => {
        fetch('http://localhost:8080/api/products')
        .then(response => response.json())
        .then(data => setProducts(data));
    
        fetch('http://localhost:8080/api/categories')
        .then(response => response.json())
        .then(data => setCategories(data));
      },[])
    
      const handleSearchChange = (event) => {
        setSearchTerm(event.target.value)
      }
    
      const handleSortChange = (event) => {
        setSortOrder(event.target.value)
      }
    
      const handleCategorySelect = (categoryId) => {
        setSelectedCategory(categoryId ? Number(categoryId) : null)
      }
    
      const filteredProducts = products.filter(product => {
       return(
        (selectedCategory ? product.category.id === selectedCategory : true)
        && 
        product.name.toLowerCase().includes(searchTerm.toLowerCase())
      
      )
      })
      .sort((a,b) => {
        if(sortOrder === "asc") {
          return a.price - b.price
        } else {
          return b.price - a.price
        }
      });
  return (
    <>
     <Header/>
    <div className="max-w-7xl mx-auto px-4 ">
    <h1 className="my-4 text-3xl font-semibold">Product Catalog</h1>
  
    <div className="flex flex-col md:flex-row md:items-center gap-4 mb-4">
      <div className="w-full md:w-1/4">
        <CategoryFilter categories={categories} onSelect={handleCategorySelect} />
      </div>
  
      <div className="w-full md:w-5/12">
        <input 
          type="text" 
          className="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500" 
          placeholder="Search for Products" 
          onChange={handleSearchChange}
        />
      </div> 
  
      <div className="w-full md:w-1/3">
        <select 
          className="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500" 
          onChange={handleSortChange}
        >
          <option value="">Sort By</option>
          <option value="asc">Price: Low to High</option>
          <option value="desc">Price: High to Low</option>
        </select>
      </div>
    </div>
  
    <div>
      {filteredProducts.length ? (
        <ProductList products={filteredProducts} />
      ) : (
        <p className='bg-orange-500 text-white p-2 rounded-md'>No Products found</p>
      )}
    </div>
  </div>
  </>
  )
}

export default Home