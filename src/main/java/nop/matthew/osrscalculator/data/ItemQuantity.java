/*
 * Copyright 2021 Matthew C. <Chapman.L.Matthew@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nop.matthew.osrscalculator.data;

public class ItemQuantity {
	private final Item item;
	private final float quantity;

	public ItemQuantity(Item item, float quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public String getName() {
		return this.item.toString();
	}

	public int getId() {
		return this.item.getId();
	}

	public float getQuantity() {
		return this.quantity;
	}
}
