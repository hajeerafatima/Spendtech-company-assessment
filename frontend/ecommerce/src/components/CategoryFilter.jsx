import React from 'react'

const CategoryFilter = ({ categories, onSelect }) => {
  return (
    <>
     <select
      id="categorySelect"
      className="w-full border border-gray-300 rounded px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
      onChange={(e) => onSelect(e.target.value)}
    >
      <option value="">All Category</option>
      {categories.map((category) => (
        <option key={category.id} value={category.id}>
          {category.name}
        </option>
      ))}
    </select>
    </>
  )
}

export default CategoryFilter